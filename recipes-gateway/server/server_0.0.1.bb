SUMMARY = "Python back end"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01d6f96ddf706e595e24681c212042cb"

RDEPENDS_${PN} = "python3 python3-modules python3-pyopenssl python3-twisted"

SRC_URI = "git://github.com/ProyectoLuna/Server.git;protocol=git;rev=master"

S = "${WORKDIR}/git"

DEST_DIR = "/opt/server"

do_install() {
    install -d ${D}${DEST_DIR}

    cp -Rp ${S}/* ${D}${DEST_DIR}
    install -m 0755 main.py ${D}${DEST_DIR}
}

FILES_${PN} = "${DEST_DIR}/*"