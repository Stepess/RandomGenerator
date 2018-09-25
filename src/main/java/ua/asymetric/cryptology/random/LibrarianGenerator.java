package ua.asymetric.cryptology.random;


import java.io.*;

public class LibrarianGenerator implements RandomGenerator {

    private static final String TEXT_PATH =
            "D:\\Programming\\AsymCrypt\\RandomGenerator\\src\\main\\resource\\text.txt";
    private InputStream stream;
    private File source;

    public LibrarianGenerator() {
        source = new File(TEXT_PATH);
        updateState();
    }

    public InputStream getStream() {
        return stream;
    }

    @Override
    public void updateState() {
        try {
            stream = new FileInputStream(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int generate() {
        int res = 0;

        try {
            res = stream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (res == -1) {
            try {
                stream.close();
                updateState();
                res = stream.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return res;
    }
}