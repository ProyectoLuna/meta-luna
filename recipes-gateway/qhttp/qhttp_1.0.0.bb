SUMMARY = "A light-weight and asynchronous HTTP library (both server & client) in Qt5 and c++14"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c758fe2787c648b41befe35a54326b03"

SRC_URI = "git://github.com/azadkuh/qhttp;protocol=git;rev=master"

S = "${WORKDIR}/git"

DEPENDS += " \
    qtbase \
"

inherit qmake5

LIBNAME = "lib${PN}.so.${PV}"

INSANE_SKIP_${PN} = "ldflags"

do_configure() {
    cd ${S}
    ./update-dependencies.sh
    ${OE_QMAKE_QMAKE} -r qhttp.pro \
        OE_QMAKE_CXX="${OE_QMAKE_CXX}" \
        OE_QMAKE_CC="${OE_QMAKE_CC}" \
        OE_QMAKE_LINK="${OE_QMAKE_LINK}" \
        OE_QMAKE_CFLAGS="${OE_QMAKE_CFLAGS}" \
        OE_QMAKE_CXXFLAGS="${OE_QMAKE_CXXFLAGS}" \
        OE_QMAKE_AR="${OE_QMAKE_AR}"
}

do_compile() {
    cd ${S}
    
    # qmake can't find the OE_QMAKE_* variables on it's own so directly passing them as
    # arguments here
    OE_QMAKE_CC="${OE_QMAKE_CC}" \
    OE_QMAKE_CFLAGS="${OE_QMAKE_CFLAGS}" \
    OE_QMAKE_CXX="${OE_QMAKE_CXX}" \
    OE_QMAKE_CXXFLAGS="${OE_QMAKE_CXXFLAGS}" \
    OE_QMAKE_LINK="${OE_QMAKE_LINK}" \
    make
}

do_install() {
    install -d ${D}${libdir}
    oe_soinstall ${S}/xbin/${LIBNAME} ${D}${libdir}

    install -d ${D}${includedir}
    install -m 0644 ../git/src/*.hpp ${D}${includedir}
}

FILES_${PN} += " \
                ${includedir}/*.hpp \
                "
FILES_${PN}-dev += " \
                ${includedir}/*.hpp \
                "
