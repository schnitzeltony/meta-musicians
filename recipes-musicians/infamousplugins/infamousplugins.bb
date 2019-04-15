SUMMARY = "Audio plugins in the LV2 format"
HOMEPAGE = "http://ssj71.github.io/infamousPlugins/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS += " \
    cairo \
    lv2 \
    ntk ntk-native \
    zita-resampler \
    fftw \
"

inherit cmake pkgconfig gtk-icon-cache

SRC_URI = " \
    git://github.com/ssj71/infamousPlugins.git \
"
SRCREV = "28b405414a5d044e576ab00b75ceaa1c0a7b8929"
S = "${WORKDIR}/git"
PV = "0.3.0"

EXTRA_OECMAKE += " \
    -DLIBDIR=${baselib} \
"

FILES_${PN} += "${libdir}/lv2"
