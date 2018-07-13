package org.meow.meow.services.interfaces;

import javax.servlet.http.Part;
import java.io.IOException;

public interface IPFSService {
    String add(Part image, String name) throws IOException;
    byte[] get(String hash) throws IOException;
}