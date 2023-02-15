package eapli.base.questionnaire.domain.Section;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Section_Id implements ValueObject {

    private long section_id;

    protected Section_Id() {}

    public Section_Id(long section_id) {
        checkSection_id(section_id);
        this.section_id = section_id;
    }

    private void checkSection_id(long section_id)
    {
        if (StringUtils.isBlank(String.valueOf(section_id)))
            throw new AssertionError("Section_id cannot be blank.");
    }

    public long getSection_id() {
        return section_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section_Id that = (Section_Id) o;
        return section_id == that.section_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(section_id);
    }

    @Override
    public String toString() {
        return "" + section_id;
    }
}
