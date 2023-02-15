grammar Questionnaire;

//Questionnaire---------------------------------------------------------------------------------------------------------
questionnaire: ID TITLE QUESTIONNAIRE_TYPE QUESTIONNAIRE_TYPE_CONDITION WELCOME_MESSAGE FINAL_MESSAGE NUMBER_OF_DAYS_IT_WILL_BE_PERFORMED section+ ;

ID: 'Questionnaire_ID='()[a-zA-Z]+'-'INT ;

TITLE: 'Questionnaire_Title='STRING ;

QUESTIONNAIRE_TYPE: 'Questionnaire_Type='STRING;

QUESTIONNAIRE_TYPE_CONDITION: 'Questionnaire_Type_Condition='INT;

WELCOME_MESSAGE: 'Questionnaire_Welcome_Message='STRING // Optional
| 'Questionnaire_Welcome_Message=';

FINAL_MESSAGE: 'Questionnaire_Final_Message='STRING ;

NUMBER_OF_DAYS_IT_WILL_BE_PERFORMED: 'Questionnaire_Number_Of_Days_It_Will_Be_Performed='INT ;

//Section---------------------------------------------------------------------------------------------------------------
section: SECTION_ID SECTION_TITLE SECTION_DESCRIPTION OBLIGATORINESS REPEATABILITY question+ ;

SECTION_ID: 'Section_ID='INT ;

SECTION_TITLE: 'Section_Title='STRING ;

SECTION_DESCRIPTION: 'Section_Description='STRING   // Optional
| 'Section_Description=';

OBLIGATORINESS: 'Obligatoriness=MANDATORY'
| 'Obligatoriness=OPTIONAL'
| 'Obligatoriness=CONDITION_DEPENDENT';

REPEATABILITY: 'Section_repeatability=TRUE'   // Optional
| 'Section_repeatability=FALSE'
| 'Section_repeatability=';

//Question--------------------------------------------------------------------------------------------------------------
question: QUESTION_ID QUESTION_TEXT INSTRUCTION TYPE OBLIGATORINESS extra_info ;

QUESTION_ID: 'Question_ID='INT ;

QUESTION_TEXT: 'Question='STRING ;

INSTRUCTION: 'Question_Instruction='STRING  // Optional
| 'Question_Instruction=' ;

TYPE: 'Question_Type=FREE_TEXT'
| 'Question_Type=NUMERIC'
| 'Question_Type=SINGLE_CHOICE'
| 'Question_Type=SINGLE_CHOICE_WITH_INPUT_VALUE'
| 'Question_Type=MULTIPLE_CHOICE'
| 'Question_Type=MULTIPLE_CHOICE_WITH_INPUT_VALUE'
| 'Question_Type=SORTING_OPTIONS'
| 'Question_Type=SCALING_OPTIONS' ;

extra_info: OPTION+
| OPTION* INPUT_VALUE;

OPTION: 'Extra_Info_Option='STRING   // E.g.: Brand
| 'Extra_Info_Option='INT            // E.g.: 2
| 'Extra_Info_Option='INT'-'INT   // E.g.: 0-5
| 'Extra_Info_Option='INT'+' ;         // E.g.: 75+

INPUT_VALUE: 'Extra_Info_Input_Value='STRING
| 'Extra_Info_Input_Value='INT ;

STRING: (~["\n\r])+ ;
INT: [0-9]+;
//----------------------------------------------------------------------------------------------------------------------
WS :[ \t\r\n]+ -> skip ; // skip spaces, tabs and lines