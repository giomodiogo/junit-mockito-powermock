package giomodiogo.business;

import com.giomodiogo.business.CustomerService;
import com.giomodiogo.dao.ICustomerDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class JUnitBDDStyleAndHamcrestTest {

    @InjectMocks //ICustomerDAO#customerDAO will be injected into CustomerService
    CustomerService customerService;

    @Mock
    ICustomerDAO customerDAO;

    @Test
    void givenCustomerListWhenGetByIdThenFilterByName() {
        // Given
        List<String> list = Stream.of("Diogo", "John", "James").collect(Collectors.toList());
        given(customerDAO.list()).willReturn(list);

        // When
        int listSize = customerService.getByName("James").size();

        // Then
        assertThat(listSize, is(1));
    }

    @Test
    public void givenArrayAndValuesWhenValuesFoundInArrayInOrderThenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat(hamcrestMatchers,
                arrayContaining("collections", "beans", "text", "number"));
    }

    @Test
    public void givenMapAndKeyWhenKeyFoundInMapThenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("1a1", "Diogo");
        map.put("2a2", "James");
        assertThat(map, hasKey("1a1"));
    }

    @Test
    public void given2StringsWhenEqualRegardlessWhiteSpaceThenCorrect() {
        String str1 = "text";
        String str2 = " text ";
        assertThat(str1, equalToCompressingWhiteSpace(str2));
    }
}
