package hacaton.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Getter
@EqualsAndHashCode
@ToString
@Builder
@JsonDeserialize(builder = EntityClass.EntityClassBuilder.class)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EntityClass {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @JsonPOJOBuilder(withPrefix = "")
    public static class EntityClassBuilder {
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDate effectiveFromDate;
    }
}


