package eapli.base.app.backoffice.console.presentation.productorder;

import eapli.framework.actions.Action;

public class UpdateOrderAction implements Action {

    @Override
    public boolean execute() {
        return new UpdateProductOrderUI().show();
    }
}
