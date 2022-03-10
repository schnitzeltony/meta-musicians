SUMMARY = "Sorcer is a polyphonic wavetable synth LV2 plugin"
HOMEPAGE = "http://openavproductions.com/sorcer"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

inherit cmake pkgconfig

DEPENDS = " \
    boost \
    cairo \
    lv2 \
    ntk \
"

SRC_URI = " \
    git://github.com/openAVproductions/openAV-Sorcer.git;protocol=https;branch=master \
    file://0001-Do-not-overwrite-build-flags-it-causes-trouble-for-m.patch \
    file://0002-Fix-build-with-lv2-1.1.18.patch \
"
SRCREV = "0a8cef484174aae5c1b7be6710f31a643e7d7197"
PV = "1.1.3+git${SRCPV}"
S = "${WORKDIR}/git"

FILES:${PN} += " \
    ${libdir}/lv2 \
"
