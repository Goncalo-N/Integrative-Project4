package eapli.base.app.backoffice.console.presentation.customer;

import eapli.framework.actions.Action;

public class RegisterCustomerAction  implements Action {

    @Override
    public boolean execute() {
        return new RegisterCustomerUI().show();
    }
}
