package innovimax.mixthem.rest.request;

public enum AlternateMode {
    _CHAR("char"),
    _LINE("line");

    private final String name;

    private AlternateMode(String name) {
        this.name = name;
    }

    private String getName() {
        return this.name;
    }

    public static boolean accept(String name) {
        for (AlternateMode mode : values()) {
            if (mode.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static String printList() {
        StringBuffer st = new StringBuffer();
        st.append("[");
        for (AlternateMode mode : values()) {
            st.append(st.length() == 0 ? "" : ", ");
            st.append(mode.getName());            
        }
        st.append("]");
        return st.toString();
    }

}
