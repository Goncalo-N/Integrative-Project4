package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.app.backoffice.console.presentation.customer.RegisterCustomerUI;
import eapli.framework.actions.Action;

public class RegisterProductAction implements Action{

    @Override
    public boolean execute() {
        return new RegisterProductUI().show();
    }
}
