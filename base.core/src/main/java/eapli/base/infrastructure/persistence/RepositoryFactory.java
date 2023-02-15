/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.persistence;

import eapli.base.questionnaire.repository.AnswerRepository;
import eapli.base.warehouse.agvdock.repository.AGVDOCKRepository;
import eapli.base.warehouse.aisle.repository.AisleRepository;
import eapli.base.warehouse.agv.repositories.AGVRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.customer.repository.AddressRepository;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.product.repository.PhotoRepository;
import eapli.base.product.repository.ProductRepository;
import eapli.base.warehouse.repository.LineRepository;
import eapli.base.questionnaire.repository.QuestionRepository;
import eapli.base.questionnaire.repository.QuestionnaireRepository;
import eapli.base.questionnaire.repository.SectionRepository;
import eapli.base.warehouse.rows.repository.RowsRepository;
import eapli.base.warehouse.repository.TaskRepository;
import eapli.base.warehouse.repository.WarehouseRepository;
import eapli.base.warehouse.repository.ProductOrderRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx
     *            the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    CustomerRepository customerRepository();

    RowsRepository rowsRepository();

    AisleRepository aisleRepository();

    WarehouseRepository warehouseRepository();

    AGVDOCKRepository agvdockRepository();

    ProductOrderRepository productOrderRepository();

    AGVRepository agvRepository();

    ProductRepository productRepository();

    PhotoRepository photoRepository();

    AddressRepository addressRepository();

    LineRepository lineRepository();

    QuestionnaireRepository questionnaireRepository();

    SectionRepository sectionRepository();

    QuestionRepository questionRepository();

    TaskRepository taskRepository();

    AnswerRepository answerRepository();
}
