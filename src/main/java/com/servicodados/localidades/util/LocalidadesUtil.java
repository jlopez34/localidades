package com.servicodados.localidades.util;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

public abstract class LocalidadesUtil {


    public static String convert(InputStream inputStream, Charset charset) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
