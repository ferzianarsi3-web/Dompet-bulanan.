DOMPET BULANAN - PROTOTIPE ANDROID v1.1

Fitur:
- Catat pemasukan dan pengeluaran
- Kategori transaksi dan tanggal
- Ringkasan saldo bulan berjalan
- Anggaran pengeluaran bulanan
- Laporan ringkas, ekspor CSV
- Cadangkan/pulihkan data JSON
- Cari transaksi berdasarkan keterangan/kategori
- Edit dan hapus transaksi
- Penyimpanan lokal offline (WebView localStorage)

CARA MEMBANGUN APK DARI HP ANDROID:
1. Ekstrak ZIP proyek.
2. Buat repository baru di github.com dan unggah seluruh isi folder proyek (termasuk folder .github).
3. Buka tab Actions dan jalankan workflow "Build APK" dengan tombol Run workflow.
4. Setelah build selesai, buka hasil workflow, bagian Artifacts, unduh "Dompet-Bulanan-debug-apk".
5. Ekstrak artifact dan instal app-debug.apk. Izinkan instalasi aplikasi dari sumber ini jika Android meminta.

CATATAN:
- Ini proyek sumber; APK harus dibangun melalui GitHub Actions.
- APK debug cocok untuk pengujian, belum ditandatangani untuk distribusi Play Store.
- Data tersimpan lokal di perangkat. Cadangkan data secara berkala.
- Belum ada sinkronisasi cloud, login, enkripsi khusus, atau pembayaran premium.
