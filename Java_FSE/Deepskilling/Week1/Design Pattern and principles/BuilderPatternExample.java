public class BuilderPatternExample {

    public static void main(String[] args) {
        Computer gamingPc = new Computer.Builder("Intel i9", "32GB")
                .storage("2TB NVMe SSD")
                .graphicsCard("NVIDIA RTX 4080")
                .bluetoothEnabled(true)
                .build();

        Computer officePc = new Computer.Builder("Intel i5", "16GB")
                .storage("512GB SSD")
                .build();

        System.out.println("Gaming PC -> " + gamingPc);
        System.out.println("Office PC -> " + officePc);
    }
}
class Computer {

    private final String cpu;
    private final String ram;
    private final String storage;
    private final String graphicsCard;
    private final boolean bluetoothEnabled;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + cpu +
                ", RAM=" + ram +
                ", Storage=" + storage +
                ", GraphicsCard=" + (graphicsCard == null ? "Integrated" : graphicsCard) +
                ", Bluetooth=" + bluetoothEnabled + "]";
    }
    public static class Builder {
        private final String cpu;
        private final String ram;
        private String storage = "256GB SSD";
        private String graphicsCard;
        private boolean bluetoothEnabled = false;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder bluetoothEnabled(boolean enabled) {
            this.bluetoothEnabled = enabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
