SUMMARY = "Base library to communitace with daemons"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01d6f96ddf706e595e24681c212042cb"

SRC_URI = "git://github.com/ProyectoLuna/daemon-communication.git;protocol=git;rev=master"

S = "${WORKDIR}/git"

inherit pkgconfig
inherit cmake

LIBNAME = "lib${PN}.so.${PV}"

INSANE_SKIP_${PN} = "ldflags"

do_install() {
    install -d ${D}${libdir}
    oe_soinstall ${LIBNAME} ${D}${libdir}

    install -d ${D}${includedir}
    install -m 0644 ../git/inc/*.h ${D}${includedir}
}

FILES_${PN} += " \
                ${includedir}/*.h \
                "
FILES_${PN}-dev += " \
                ${includedir}/*.h \
                "
