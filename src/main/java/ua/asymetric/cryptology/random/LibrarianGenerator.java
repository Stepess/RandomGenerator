package ua.asymetric.cryptology.random;


import java.io.*;

public class LibrarianGenerator extends RandomGenerator {
    private static final String GENERATOR_NAME = "Librarian";
    private static final String TEXT_PATH =
            "src\\main\\resource\\lotr.txt";
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

    @Override
    public byte generateRandomByte() {
        return (byte) generate();
    }

    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }
}