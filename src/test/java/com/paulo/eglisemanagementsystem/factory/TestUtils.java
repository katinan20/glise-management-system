package com.paulo.eglisemanagementsystem.factory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.MediaType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>Classe d'utilité pour tester les contrôleurs REST.</p>
 */

public class TestUtils {
    /**
     * MediaType for JSON UTF8
     */
    public static final MediaType APPLICATION_JSON = MediaType.APPLICATION_JSON;
    private static final ObjectMapper mapper = createObjectMapper();

    private TestUtils() {
    }

    private static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    /**
     * Convert an object to JSON byte array.
     *
     * @param object the object to convert.
     * @return the JSON byte array.
     */
    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        return mapper.writeValueAsBytes(object);
    }

    public static byte[] convertObjectsToJsonBytes(List<Object> objects) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writeValue(out, objects);
        final byte[] data = out.toByteArray();
        System.out.println(new String(data));
        return data;
    }

    /**
     * Create a byte array with a specific size filled with specified data.
     *
     * @param size the size of the byte array.
     * @param data the data to put in the byte array.
     * @return the JSON byte array.
     */
    public static byte[] createByteArray(int size, String data) {
        byte[] byteArray = new byte[size];
        for (int i = 0; i < size; i++) {
            byteArray[i] = Byte.parseByte(data, 2);
        }
        return byteArray;
    }

    /**
     * Creates a matcher that matches when the examined string represents the same instant as the
     * reference datetime.
     *
     * @param date the reference datetime against which the examined string is checked.
     */
    public static ZonedDateTimeMatcher sameInstant(ZonedDateTime date) {
        return new ZonedDateTimeMatcher(date);
    }

    /**
     * Verifies the equals/hashcode contract on the domain object.
     */
    public static <T> void equalsVerifier(Class<T> clazz) throws Exception {
        T domainObject1 = clazz.getConstructor().newInstance();
        assertThat(domainObject1.toString()).isNotNull();
        assertThat(domainObject1).isEqualTo(domainObject1);
        assertThat(domainObject1.hashCode()).isEqualTo(domainObject1.hashCode());
        // Test with an instance of another class
        Object testOtherObject = new Object();
        assertThat(domainObject1).isNotEqualTo(testOtherObject);
        assertThat(domainObject1).isNotEqualTo(null);
        // Test with an instance of the same class
        T domainObject2 = clazz.getConstructor().newInstance();
        assertThat(domainObject1).isNotEqualTo(domainObject2);
        // HashCodes are equals because the objects are not persisted yet
        assertThat(domainObject1.hashCode()).isEqualTo(domainObject2.hashCode());
    }

    /**
     * Create a {@link FormattingConversionService} which use ISO date format, instead of the
     * localized one.
     *
     * @return the {@link FormattingConversionService}.
     */
    public static FormattingConversionService createFormattingConversionService() {
        DefaultFormattingConversionService dfcs = new DefaultFormattingConversionService();
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setUseIsoFormat(true);
        registrar.registerFormatters(dfcs);
        return dfcs;
    }

    /**
     * A matcher that tests that the examined string represents the same instant as the reference
     * datetime.
     */
    public static class ZonedDateTimeMatcher extends TypeSafeDiagnosingMatcher<String> {

        private final ZonedDateTime date;

        public ZonedDateTimeMatcher(ZonedDateTime date) {
            this.date = date;
        }

        @Override
        protected boolean matchesSafely(String item, Description mismatchDescription) {
            try {
                if (!date.isEqual(ZonedDateTime.parse(item))) {
                    mismatchDescription.appendText("was ").appendValue(item);
                    return false;
                }
                return true;
            } catch (DateTimeParseException e) {
                mismatchDescription.appendText("was ").appendValue(item)
                        .appendText(", which could not be parsed as a ZonedDateTime");
                return false;
            }

        }

        @Override
        public void describeTo(Description description) {
            description.appendText("a String representing the same Instant as ").appendValue(date);
        }
    }
}
