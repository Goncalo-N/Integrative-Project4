package eapli.base.questionnaire.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaire.domain.Obligatoriness;
import eapli.base.questionnaire.domain.Section.*;
import eapli.base.questionnaire.repository.SectionRepository;

import static eapli.base.questionnaire.domain.Obligatoriness.MANDATORY;

public class ListSection {

    private final SectionRepository repository = PersistenceContext.repositories().sectionRepository();

    public Iterable<Section> listAllSections() {
        return this.repository.findAll();
    }

    public Section getSectionByID(Section_Id sectionID) {
        Section section = new Section(new Section_Id(1),new Section_Title("ABC"),new Section_Description(""), MANDATORY,new Section_Condition(""),new Section_Repeatability(""),null);
        for (Section s : listAllSections()) {
            if (s.getSection_id().getSection_id() == sectionID.getSection_id()) {
                section.setSection_id(s.getSection_id());
                section.setSection_title(s.getSection_title());
                section.setSection_description(s.getSection_description());
                section.setObligatoriness(s.getObligatoriness());
                section.setCondition(s.getCondition());
                section.setRepeatability(s.getRepeatability());
                section.setContent(s.getContent());
            }
        }
        return section;
    }
}
