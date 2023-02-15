package eapli.base.questionnaire.domain.Section;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Section_Title implements ValueObject {

    private String title;

    protected Section_Title() {}

    public Section_Title(String title) {
        checkSection_title(title);
        this.title = title;
    }

    private void checkSection_title(String section_title)
    {
        if (StringUtils.isBlank(section_title))
            throw new IllegalArgumentException("Section_title cannot be blank.");
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section_Title that = (Section_Title) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
