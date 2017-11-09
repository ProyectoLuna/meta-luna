SUMMARY = "Cute logger"

LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "git://github.com/dept2/CuteLogger.git;protocol=git;rev=master"

S = "${WORKDIR}/git"

DEPENDS = "qtdeclarative"

require recipes-qt/qt5/qt5.inc

inherit pkgconfig

#LIBNAME = "libCuteLogger.so.${PV}"
LIBNAME = "libCuteLogger.so.1.0.0"

INSANE_SKIP_${PN} = "ldflags"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${libdir}
    oe_soinstall ${LIBNAME} ${D}${libdir}

    install -d ${D}${includedir}
    install -m 0644 ${S}/include/*.h ${D}${includedir}
}

FILES_${PN} += " \
                ${includedir}/*.h \
                "
FILES_${PN}-dev += " \
                ${includedir}/*.h \
                "
RDEPENDS_${PN} = "qtdeclarative-qmlplugins"
