package innovimax.mixthem.rest.request;

public enum ZipMode {
    _CHAR("char"),
    _LINE("line"),
    _CELL("cell");

    private final String name;

    private ZipMode(String name) {
        this.name = name;
    }

    private String getName() {
        return this.name;
    }

    public static boolean accept(String name) {
        for(ZipMode mode : values()) {
            if (mode.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static String printList() {
        StringBuffer st = new StringBuffer();
        st.append("[");
        for (ZipMode mode : values()) {
            st.append(st.length() == 0 ? "" : ", ");
            st.append(mode.getName());            
        }
        st.append("]");
        return st.toString();
    }

}
