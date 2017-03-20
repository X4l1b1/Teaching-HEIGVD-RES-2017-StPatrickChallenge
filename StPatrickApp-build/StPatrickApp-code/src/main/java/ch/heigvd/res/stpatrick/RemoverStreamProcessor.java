package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * The responsibility of this class is to read characters from an input
 * reader, to process them, and to write them to an output writer.
 *
 * It is called "basic" stream processor, because it does nothing with the
 * characters: it writes them without transforming them.
 *
 * Note: clients do not instantiate this class directly. They obtain instances
 * of this class via the StreamProcessorsFactory.
 *
 * @author Arthur Passuello
 */
class RemoverStreamProcessor implements IStreamProcessor {

    @Override
    public void process(Reader in, Writer out) throws IOException {
        BufferedReader br = new BufferedReader(in);
        BufferedWriter bw = new BufferedWriter(out);
        String c = br.read();
        while (c != -1) {
            if((char) c == 'e' || (char) c == 'E'){ continue;}
            bw.write((char) c);
            c = br.read();
        }

        bw.flush();
    }

}
