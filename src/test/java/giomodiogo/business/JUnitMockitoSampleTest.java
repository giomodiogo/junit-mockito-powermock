package giomodiogo.business;

import com.giomodiogo.business.CustomerService;
import com.giomodiogo.dao.ICustomerDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JUnitMockitoSampleTest {

    @Mock
    Stream mockStream =  Stream.empty();

    @InjectMocks //ICustomerDAO#customerDAO will be injected into CustomerService
    CustomerService customerService;

    @Mock
    ICustomerDAO customerDAO;

    @Test
    void checkStreamMock(){
        when(mockStream.count()).thenReturn((long) 10);
        assertEquals(10, mockStream.count());
    }

    @Test
    void getCustomersCount(){
        List<String> list = Stream.of("Diogo", "John").collect(Collectors.toList());
        when(customerService.list()).thenReturn(list);
        assertEquals(2, customerService.list().size());
    }

    @Test
    void filterByCustomerName(){
        List<String> list = Stream.of("Diogo", "John", "James").collect(Collectors.toList());
        when(customerDAO.list()).thenReturn(list);
        assertEquals(1, customerService.getByName("Diogo").size());
    }

    @Test
    void saveCustomerAndReturnId(){
        UUID id = UUID.randomUUID();
        String name = "Diogo";
        when(customerDAO.save(name)).thenReturn(id);
        assertEquals(id, customerService.save(name));
    }
}
