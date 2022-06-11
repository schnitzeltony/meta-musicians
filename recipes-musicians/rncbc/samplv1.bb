SUMMARY = "An old-school polyphonic sampler"
HOMEPAGE = "http://samplv1.sourceforge.net"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qtbase \
    qtsvg \
    jack \
    lv2 \
    liblo \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache mime mime-xdg

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0002-Avoid-stripping-CMake.patch \
"
PV = "0.9.26"
SRC_URI[sha256sum] = "91b680d97efad89dcb98221b9cc7df733dcc8a437666184ba862c2341c1c1fe7"

FILES:${PN} += " \
    ${datadir}/appdata \
    ${datadir}/mime \
    ${datadir}/metainfo \
    ${datadir}/icons \
    ${libdir}/lv2 \
"
