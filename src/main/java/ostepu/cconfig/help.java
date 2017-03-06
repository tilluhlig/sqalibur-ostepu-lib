/* 
 * Copyright (C) 2017 Till Uhlig <till.uhlig@student.uni-halle.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ostepu.cconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;

/**
 * dieser Befehl liefert Dateien des "help" Ordners als Hilfedateien für OSTEPU
 *
 * @author Till
 */
public class help {

    /**
     * der Aufruf des help-Befehls
     *
     * @param context  der Kontext des Servlet
     * @param request  die eingehende Anfrage
     * @param response das Antwortobjekt
     */
    public static void request(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            try {
                response.sendError(404);
            } catch (IOException ex) {
                Logger.getLogger(help.class.getName()).log(Level.SEVERE, null, ex);
                response.setStatus(500);
            }
            return;
        }

        if (!"GET".equals(request.getMethod())) {
            System.out.println("bb");
            try {
                response.sendError(404);
            } catch (IOException ex) {
                Logger.getLogger(help.class.getName()).log(Level.SEVERE, null, ex);
                response.setStatus(500);
            }
            return;
        }

        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(help.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(500);
            return;
        }
        String[] helpPath = pathInfo.split("/");
        String extension = FilenameUtils.getExtension(pathInfo);
        String language = helpPath[1];
        helpPath[helpPath.length - 1] = helpPath[helpPath.length - 1].substring(0, helpPath[helpPath.length - 1].length() - extension.length() - 1);
        helpPath = Arrays.copyOfRange(helpPath, 2, helpPath.length);

        Path helpFile = Paths.get(context.getRealPath("data/help/" + String.join("_", helpPath) + "_" + language + "." + extension));

        try {
            if (Files.exists(helpFile)) {
                out.write(String.join("\n", Files.readAllLines(helpFile)));
                response.setStatus(200);
            } else {
                response.sendError(404);
            }
        } catch (IOException ex) {
            Logger.getLogger(help.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(500);
        } finally {
            out.close();
        }
    }

}
