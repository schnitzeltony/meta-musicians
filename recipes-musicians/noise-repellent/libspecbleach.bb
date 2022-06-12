SUMMARY = "C library for audio noise reduction and other spectral effects"
HOMEPAGE = "https://github.com/lucianodato/libspecbleach"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742"

inherit meson pkgconfig

DEPENDS += " \
    fftw \
"
PV = "0.1.6"
SRC_URI = " \
    git://github.com/lucianodato/libspecbleach.git;branch=main;protocol=https \
    file://0001-do-not-pin-sse-flags-they-won-t-work-on-all-arches.patch \
"
SRCREV = "49249a3c133a29686358c10c0cf68d2d826e8f0d"
S = "${WORKDIR}/git"

FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libspecbleach.so"
