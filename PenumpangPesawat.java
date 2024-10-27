// Kelas Passenger
class Passenger {
    String name;
    Passenger next;

    // Konstruktor
    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

// Kelas Flight
class Flight {
    private Passenger head;

    // Metode menambah penumpang di akhir daftar
    public void addPassenger(String nama) {
        Passenger newPassenger = new Passenger(nama);
        if (head == null) {
            // Jika daftar kosong, penumpang baru menjadi kepala
            head = newPassenger;
        } else {
            // Jika tidak kosong, cari penumpang terakhir dan tambahkan penumpang baru
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    // Metode menghapus penumpang dari daftar berdasarkan nama
    public void removePassenger(String nama) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        // Jika penumpang yang akan dihapus adalah kepala
        if (head.name.equals(nama)) {
            head = head.next;
            System.out.println(nama + " telah dihapus dari daftar penumpang.");
            return;
        }

        // Mencari penumpang untuk dihapus
        Passenger current = head;
        Passenger previous = null;

        while (current != null && !current.name.equals(nama)) {
            previous = current;
            current = current.next;
        }

        // Jika penumpang ditemukan
        if (current != null) {
            previous.next = current.next;
            System.out.println(nama + " telah dihapus dari daftar penumpang.");
        } else {
            System.out.println(nama + " tidak ditemukan dalam daftar penumpang.");
        }
    }

    // Metode menampilkan semua penumpang
    public void displayPassengers() {
        Passenger current = head;
        if (current == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }
        System.out.println("Daftar Penumpang:");
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }
}

// Kelas untuk menguji Flight
public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight();

        // Menambahkan penumpang ke daftar
        flight.addPassenger("Ghani");
        flight.addPassenger("Hania");
        flight.addPassenger("Khalisa");

        // Menampilkan daftar penumpang
        flight.displayPassengers();

        // Menghapus penumpang
        flight.removePassenger("Hania");

        // Menampilkan daftar penumpang setelah penghapusan
        flight.displayPassengers();

        //Menghapus penumpang yang tidak ada
        flight.removePassenger("David");
    }
}
