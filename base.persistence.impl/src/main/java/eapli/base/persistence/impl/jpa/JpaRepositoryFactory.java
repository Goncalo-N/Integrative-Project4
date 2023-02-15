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
package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.questionnaire.repository.AnswerRepository;
import eapli.base.warehouse.agvdock.repository.AGVDOCKRepository;
import eapli.base.warehouse.aisle.repository.AisleRepository;
import eapli.base.warehouse.agv.repositories.AGVRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.customer.repository.AddressRepository;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.product.repository.PhotoRepository;
import eapli.base.product.repository.ProductRepository;
import eapli.base.warehouse.repository.LineRepository;
import eapli.base.warehouse.repository.ProductOrderRepository;
import eapli.base.questionnaire.repository.QuestionRepository;
import eapli.base.questionnaire.repository.QuestionnaireRepository;
import eapli.base.questionnaire.repository.SectionRepository;
import eapli.base.warehouse.rows.repository.RowsRepository;
import eapli.base.warehouse.repository.TaskRepository;
import eapli.base.warehouse.repository.WarehouseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public CustomerRepository customerRepository() {
        return new JpaCustomerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public RowsRepository rowsRepository() {
        return new JpaRowsRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public AisleRepository aisleRepository() {
        return new JpaAisleRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public WarehouseRepository warehouseRepository() {
        return new JpaWarehouseRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public AGVDOCKRepository agvdockRepository() {
        return new JpaAGVDOCKRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ProductOrderRepository productOrderRepository() {
        return new JpaProductOrderRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public AGVRepository agvRepository() {
        return new JpaAGVRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ProductRepository productRepository() {
        return new JpaProductRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public PhotoRepository photoRepository() {
        return new JpaPhotoRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public AddressRepository addressRepository() {
        return new JpaAddressRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public LineRepository lineRepository() {
        return new JpaLineRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public QuestionnaireRepository questionnaireRepository() {
        return new JpaQuestionnaireRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SectionRepository sectionRepository() {
        return new JpaSectionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public QuestionRepository questionRepository() {
        return new JpaQuestionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TaskRepository taskRepository() {
        return new JpaTaskRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public AnswerRepository answerRepository() {
        return new JpaAnswerRepository(Application.settings().getPersistenceUnitName());
    }
}
