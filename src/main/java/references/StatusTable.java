package references;

public enum StatusTable {
    Staff(1),
    Inpatient(2),
    Outpatient(3);

    public final int Id;

    private StatusTable(int Id) {
        this.Id = Id;
    }

}
