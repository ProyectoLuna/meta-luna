SUMMARY = "A qt library facilitating the creation of daemons (linux) "

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=47c8569d020bb31a6be08ed1d2988bf8"

SRC_URI = "git://bitbucket.org/nye/qtdaemon.git;protocol=https;rev=master"

S = "${WORKDIR}/git"

#require qt5.inc
#require qt5-git.inc

inherit qmake5

LIBNAME = "lib${PN}.so.${PV}"

INSANE_SKIP_${PN} = "ldflags"

do_configure() {
    cd ${S}
#    ${OE_QMAKE_QMAKE} -r \
#        QMAKE_CXX="${OE_QMAKE_CXX}" QMAKE_CC="${OE_QMAKE_CC}" \
#        QMAKE_LINK="${OE_QMAKE_LINK}" \
#        QMAKE_CFLAGS="${OE_QMAKE_CFLAGS}" \
#        QMAKE_CXXFLAGS="${OE_QMAKE_CXXFLAGS}" \
    /opt/poky/2.3/qt5sdk/sysroots/cortexa7hf-neon-vfpv4-poky-linux-gnueabi/usr/bin/qt5/qmake
}

do_install() {
    cd ${S}
    make
}

do_install() {
    install -d ${D}${libdir}
    oe_soinstall ${LIBNAME} ${D}${libdir}

#    install -d ${D}${includedir}
#    install -m 0644 ../git/inc/*.h ${D}${includedir}
}

#FILES_${PN} += " \
#                ${includedir}/*.h \
#                "
#FILES_${PN}-dev += " \
#                ${includedir}/*.h \
#                "
