package grails_bihar_22_23

import java.awt.Image

class Illustration {

    String filename

    static constraints = {
        filename nullable: false, blank: false
    }

    static belongsTo = [annonce: Annonce]
}
