SUMMARY = "An old-school polyphonic sampler"
HOMEPAGE = "http://samplv1.sourceforge.net"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qtbase \
    jack \
    lv2 \
    liblo \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache mime mime-xdg

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0002-Avoid-stripping-CMake.patch \
"
PV = "0.9.25"
SRC_URI[sha256sum] = "acf035da8c0f38ccd0a9bd0327d250c6338d8af56c824bf20f90673b07580534"

FILES:${PN} += " \
    ${datadir}/appdata \
    ${datadir}/mime \
    ${datadir}/metainfo \
    ${datadir}/icons \
    ${libdir}/lv2 \
"
