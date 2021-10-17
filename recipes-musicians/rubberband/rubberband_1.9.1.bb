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
SRC_URI[sha256sum] = "fc474878f6823c27ef5df1f9616a8c8b6a4c01346132ea7d1498fe5245e549e3"

EXTRA_OEMESON = "-Dfft=fftw"

FILES:${PN} += " \
    ${datadir}/ladspa \
    ${libdir}/ladspa \
    ${libdir}/vamp \
"
