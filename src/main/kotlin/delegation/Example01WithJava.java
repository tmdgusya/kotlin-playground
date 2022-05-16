package delegation;

public class Example01WithJava {

    interface Base {
        public void print();
    }

    class BaseImpl implements delegation.Base {

        private final int x;

        public BaseImpl(int x) {
            this.x = x;
        }

        @Override
        public void print() {
            System.out.println(x);
        }
    }

    class Derived {
        private final delegation.BaseImpl base;

        public Derived(delegation.BaseImpl base) {
            this.base = base;
        }

        public void print() {
            base.print();
        }
    }
}
