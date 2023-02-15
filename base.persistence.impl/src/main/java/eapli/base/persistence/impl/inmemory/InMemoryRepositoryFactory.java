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
package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnaire.repository.AnswerRepository;
import eapli.base.warehouse.agvdock.repository.AGVDOCKRepository;
import eapli.base.warehouse.aisle.repository.AisleRepository;
import eapli.base.warehouse.agv.repositories.AGVRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.customer.repository.AddressRepository;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
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
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

    @Override
    public CustomerRepository customerRepository() {return new InMemoryCustomerRepository();}

    @Override
    public RowsRepository rowsRepository() {
        return new InMemoryRowsRepository();
    }

    @Override
    public AisleRepository aisleRepository() {
        return new InMemoryAisleRepository();
    }

    @Override
    public WarehouseRepository warehouseRepository() {
        return new InMemoryWarehouseRepository();
    }

    @Override
    public AGVDOCKRepository agvdockRepository() {
        return new InMemoryAGVDOCKRepository();
    }

    @Override
    public ProductOrderRepository productOrderRepository() {
        return new InMemoryProductOrderRepository();
    }

    @Override
    public AGVRepository agvRepository() {
        return new InMemoryAGVRepository();
    }

    @Override
    public ProductRepository productRepository() {
        return new InMemoryProductRepository();
    }

    @Override
    public PhotoRepository photoRepository() {return new InMemoryPhotoRepository();}

    @Override
    public AddressRepository addressRepository() {return new InMemoryAddressRepository();}

    @Override
    public LineRepository lineRepository() {
        return new InMemoryLineRepository();
    }

    @Override
    public QuestionnaireRepository questionnaireRepository() {
        return new InMemoryQuestionnaireRepository();
    }

    @Override
    public SectionRepository sectionRepository() {return new InMemorySectionRepository();}

    @Override
    public QuestionRepository questionRepository() {return new InMemoryQuestionRepository();}

    @Override
    public TaskRepository taskRepository() {
        return new InMemoryTaskRepository();
    }

    @Override
    public AnswerRepository answerRepository() {
        return new InMemoryAnswerRepository();
    }
}
