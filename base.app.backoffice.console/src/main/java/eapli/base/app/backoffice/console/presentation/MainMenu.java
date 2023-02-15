/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.customer.RegisterCustomerAction;
import eapli.base.app.backoffice.console.presentation.product.RegisterProductAction;
import eapli.base.app.backoffice.console.presentation.productorder.RegisterProductOrderAction;
import eapli.base.app.backoffice.console.presentation.productorder.UpdateOrderAction;
import eapli.base.app.backoffice.console.presentation.questionnaire.AnswerQuestionnaireAction;
import eapli.base.app.backoffice.console.presentation.questionnaire.CreateQuestionnaireAction;
import eapli.base.app.backoffice.console.presentation.questionnaire.CreateReportAction;
import eapli.base.app.backoffice.console.presentation.warehouse.UploadWarehouseFileAction;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;

    private static final int CUSTOMER_OPTION = 2;
    private static final int PRODUCT_OPTION = 3;
    private static final int PRODUCT_ORDER_OPTION = 4;

    private static final int SETTINGS_OPTION = 4;
    private static final int JSONUPLOAD_OPTION = 2;
    private static final int QUESTIONNAIRE_OPTION = 2;
    private static final int REPORT_OPTION = 3;
    private static final int ANSWER_OPTION = 2;
    private static final int UPDATE_ORDER_OPTION = 3;

    // CUSTOMER
    private static final int REGISTER_CUSTOMER_OPTION = 1;

    // PRODUCT ORDER
    private static final int REGISTER_PRODUCT_ORDER_OPTION = 1;

    // Questionnaire
    private static final int CREATE_QUESTIONNAIRE_OPTION = 1;
    private static final int ANSWER_QUESTIONNAIRE_OPTION = 1;
    private static final int CREATE_REPORT_OPTION = 1;

    // JSON
    private static final int JSONUPLOAD_OPTIOND = 1;
    private static final int UPDATEPRODUCTODER = 1;

    // PRODUCT
    private static final int REGISTER_PRODUCT_OPTION = 1;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }
        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.WAREHOUSE_EMPLOYEE)){
            final Menu customerMenu = buildWarehouseEmployee();
            final Menu UpdateOrder = buildUpdateProductOrderMenu();

            mainMenu.addSubMenu(JSONUPLOAD_OPTION, customerMenu);
            mainMenu.addSubMenu(UPDATE_ORDER_OPTION, UpdateOrder);
        }

        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK)){
            final Menu customerMenu = buildCustomerMenu();
            mainMenu.addSubMenu(CUSTOMER_OPTION, customerMenu);
            final Menu productMenu = buildProductMenu();
            mainMenu.addSubMenu(PRODUCT_OPTION, productMenu);
            final Menu productOrderMenu = buildProductOrderMenu();
            mainMenu.addSubMenu(PRODUCT_ORDER_OPTION, productOrderMenu);
        }

        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.SALES_MANAGER)){
            final Menu questionnaireMenu = buildQuestionnaireMenu();
            mainMenu.addSubMenu(QUESTIONNAIRE_OPTION, questionnaireMenu);
            final Menu reportMenu = buildReportMenu();
            mainMenu.addSubMenu(REPORT_OPTION, reportMenu);
        }

        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.CUSTOMER)){
            final Menu customerAnswerMenu = buildCustomerAnswerMenu();
            mainMenu.addSubMenu(ANSWER_OPTION, customerAnswerMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCustomerMenu() {
        final Menu menu = new Menu("Customers >");

        menu.addItem(REGISTER_CUSTOMER_OPTION, "Register a new Customer", new RegisterCustomerAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildWarehouseEmployee() {
        final Menu menu = new Menu("JSONFile Upload>");

        menu.addItem(JSONUPLOAD_OPTIOND, "Upload a JSON Warehouse File", new UploadWarehouseFileAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildProductMenu() {
        final Menu menu = new Menu("Products >");

        menu.addItem(REGISTER_PRODUCT_OPTION, "Register a new Product", new RegisterProductAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildProductOrderMenu() {
        final Menu menu = new Menu("Product Order >");

        menu.addItem(REGISTER_PRODUCT_ORDER_OPTION, "Register a new Product Order", new RegisterProductOrderAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildQuestionnaireMenu() {
        final Menu menu = new Menu("Questionnaire >");

        menu.addItem(CREATE_QUESTIONNAIRE_OPTION, "Create a new Questionnaire", new CreateQuestionnaireAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildUpdateProductOrderMenu(){
        final Menu menu = new Menu("Update Product Order");

        menu.addItem(UPDATEPRODUCTODER, "Update Product Order", new UpdateOrderAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildCustomerAnswerMenu() {
        final Menu menu = new Menu("Questionnaires >");

        menu.addItem(ANSWER_QUESTIONNAIRE_OPTION, "Answer a Questionnaire", new AnswerQuestionnaireAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildReportMenu() {
        final Menu menu = new Menu("Report >");

        menu.addItem(CREATE_REPORT_OPTION, "Create a Report", new CreateReportAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }
}
