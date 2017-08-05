SUMMARY = "Proyecto Luna CServer"

SRC_URI = "git://github.com/ProyectoLuna/CServer.git;protocol=git;rev=master"

LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=01d6f96ddf706e595e24681c212042cb"

DEPENDS = "boost"

inherit cmake

EXTRA_OECMAKE += "-DUSE_STATIC_BOOST=ON"

S = "${WORKDIR}/git"

do_install() {
  install -d ${D}${bindir}
  install -m 0755 cserver ${D}${bindir}
}
