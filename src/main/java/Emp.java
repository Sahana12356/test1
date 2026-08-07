import java.util.Objects;

/**
 * Emp
 */
public class Emp {
    public final String ename;
    public final int empno;

    public Emp(String ename, int empno) {
        if (ename == null || ename.isBlank()) {
            throw new IllegalArgumentException("ename must not be blank");
        }
        if (empno <= 0) {
            throw new IllegalArgumentException("empno must be positive");
        }
        this.ename = ename;
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public int getEmpno() {
        return empno;
    }

    @Override
    public String toString() {
        return ename + " " + empno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Emp)) {
            return false;
        }
        Emp other = (Emp) o;
        return empno == other.empno && ename.equals(other.ename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ename, empno);
    }
}
