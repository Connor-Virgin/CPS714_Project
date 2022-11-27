package references;

public enum Ward {
    North(1),
    West(2),
    East(3),
    South(4);

    public final int Id;

    private Ward(int Id) {
        this.Id = Id;
    }

    public static Ward getById(int id) {
        for (Ward e : values()) {
            if (e.Id == id)
                return e;
        }
        return null;
    }

}
