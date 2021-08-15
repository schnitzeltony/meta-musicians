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

SRC_URI = "git://github.com/ssj71/infamousPlugins.git"
SRCREV = "4c7275b1fa8ea3296446421cbd29ec2df66588c0"
S = "${WORKDIR}/git"
PV = "0.3.0+git${SRCPV}"

EXTRA_OECMAKE += " \
    -DLIBDIR=${baselib} \
"

FILES:${PN} += "${libdir}/lv2"
