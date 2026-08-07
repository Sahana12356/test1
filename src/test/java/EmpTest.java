import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class EmpTest {

    @Test
    void constructorStoresFields() {
        Emp emp = new Emp("Guldu", 1120);

        assertEquals("Guldu", emp.ename);
        assertEquals(1120, emp.empno);
        assertEquals("Guldu", emp.getEname());
        assertEquals(1120, emp.getEmpno());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t"})
    void constructorRejectsBlankName(String ename) {
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> new Emp(ename, 1120));
        assertEquals("ename must not be blank", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void constructorRejectsNonPositiveEmpno(int empno) {
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> new Emp("Guldu", empno));
        assertEquals("empno must be positive", ex.getMessage());
    }

    @Test
    void toStringJoinsNameAndNumber() {
        assertEquals("Dinhga 1122", new Emp("Dinhga", 1122).toString());
    }

    @Test
    void equalsAndHashCodeUseBothFields() {
        Emp emp = new Emp("Guldu", 1120);
        Emp same = new Emp("Guldu", 1120);
        Emp otherName = new Emp("Dinhga", 1120);
        Emp otherNumber = new Emp("Guldu", 1122);

        assertEquals(emp, same);
        assertEquals(emp.hashCode(), same.hashCode());
        assertTrue(emp.equals(emp));
        assertNotEquals(emp, otherName);
        assertNotEquals(emp, otherNumber);
        assertFalse(emp.equals("Guldu 1120"));
        assertFalse(emp.equals(null));
    }
}
