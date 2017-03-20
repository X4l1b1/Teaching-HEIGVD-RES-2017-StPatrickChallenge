package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


class StreamDecoratorController implements IStreamDecoratorController {


    Reader decorateReader(Reader inputReader){
        return new DecoratedReader extends BufferedReader (inputReader) {
                public int read(){
                        int c = super.read();
                        while((char) c == 'a' || (char) c == 'A'){
                             c = super.read();
                        }
                        return c;

                }
        }
    }


    Writer decorateWriter(Writer outputWriter){
        return new DecoratedWriter extends BufferedWriter (outputWriter) {

            public void write(int c){
                if((char) c == 'a' || (char) c == 'A') { return;}
                super.write(c);
            }
        }
    }
}