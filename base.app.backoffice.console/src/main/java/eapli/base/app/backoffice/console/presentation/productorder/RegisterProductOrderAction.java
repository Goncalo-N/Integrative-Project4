package eapli.base.app.backoffice.console.presentation.productorder;

import eapli.framework.actions.Action;

public class RegisterProductOrderAction  implements Action {

    @Override
    public boolean execute() {
        return new RegisterProductOrderUI().show();
    }
}
