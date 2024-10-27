public class PenumpangPesawat {
    // Kelas Passenger
    class Passenger {
        String name;
        Passenger next;

        public Passenger(String name) {
            this.name = name;
            this.next = null;
        }
    }

    // Kelas Flight
    class Flight {
        private Passenger head;

        public Flight() {
            head = null;
        }

        // Metode untuk menambah penumpang di akhir daftar
        public void addPassenger(String name) {
            Passenger newPassenger = new Passenger(name);
            if (head == null) {
                head = newPassenger;
            } else {
                Passenger current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newPassenger;
            }
        }

        // Metode untuk menghapus penumpang berdasarkan nama
        public void removePassenger(String name) {
            if (head == null) return;

            // Jika penumpang yang ingin dihapus adalah head
            if (head.name.equals(name)) {
                head = head.next;
                return;
            }

            Passenger current = head;
            while (current.next != null) {
                if (current.next.name.equals(name)) {
                    current.next = current.next.next; // Menghapus penumpang
                    return;
                }
                current = current.next;
            }
        }

        // Metode untuk menampilkan semua penumpang
        public void displayPassengers() {
            Passenger current = head;
            while (current != null) {
                System.out.println(current.name);
                current = current.next;
            }
        }
    }

    // Kelas utama untuk menjalankan program
    public class Main {
        public void main(String[] args) {
            Flight flight = new Flight();
            flight.addPassenger("Alice");
            flight.addPassenger("Bob");
            flight.addPassenger("Charlie");

            System.out.println("Daftar Penumpang:");
            flight.displayPassengers();

            // Menghapus penumpang Bob
            flight.removePassenger("Bob");

            System.out.println("Daftar Penumpang setelah menghapus Bob:");
            flight.displayPassengers();
        }
    }

}
