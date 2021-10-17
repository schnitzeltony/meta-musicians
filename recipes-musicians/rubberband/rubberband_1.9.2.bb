SUMMARY = "Rubber Band Library library for audio time-stretching and pitch-shifting"
HOMEPAGE = "http://breakfastquay.com/rubberband/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=28f6289fba0406b8f491e9b2d5767488"

inherit meson pkgconfig

DEPENDS += " \
    fftw \
    libsamplerate0 \
    vamp-plugin-sdk \
    ladspa-sdk \
"

SRC_URI = "https://breakfastquay.com/files/releases/${BPN}-${PV}.tar.bz2"
SRC_URI[sha256sum] = "b3cff5968517141fcf9e1ef6b5a1fdb06a5511f148000609216cf182ff4ab612"

EXTRA_OEMESON = "-Dfft=fftw"

FILES:${PN} += " \
    ${datadir}/ladspa \
    ${libdir}/ladspa \
    ${libdir}/vamp \
"
