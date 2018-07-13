package org.meow.meow.services.implementations;

import io.ipfs.api.IPFS;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import org.meow.meow.services.interfaces.IPFSService;

import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IPFSServiceImpl implements IPFSService {
    private IPFS ipfs;

    // Create an IPFS instance
    public IPFSServiceImpl() {
        this.ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
    }

    public String add(Part image, String name) throws IOException {
        InputStream fileContent = image.getInputStream();
        byte[] imageBytes = this.getImageBytes(fileContent);
        NamedStreamable.ByteArrayWrapper file = new NamedStreamable.ByteArrayWrapper(name, imageBytes);
        this.ipfs.add(file);
        return this.ipfs.add(file).get(0).hash.toString();
    }

    public byte[] get(String hash) throws IOException {
        Multihash filePointer = Multihash.fromBase58(hash);
        return this.ipfs.cat(filePointer);
    }

    private byte[] getImageBytes(InputStream fileContent) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = fileContent.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        return buffer.toByteArray();
    }
}