SUMMARY = "ArtyFX is a plugin bundle of artistic real-time audio effects"
HOMEPAGE = "http://openavproductions.com/artyfx/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4cc91856b08b094b4f406a29dc61db21"

inherit cmake pkgconfig

DEPENDS = " \
    virtual/libx11 \
    cairo \
    lv2 \
    libsndfile1 \
"

SRC_URI = " \
    git://github.com/openAVproductions/openAV-ArtyFX.git \
    file://0001-Do-not-overwrite-build-flags-it-causes-trouble-for-m.patch \
    file://0002-avtk-remove-sse-flags-they-work-on-intel-hardware-on.patch \
"
SRCREV = "6010d1a6034ea684cc2edb22021f034122ccf814"
S = "${WORKDIR}/git"
PV = "1.3+git${SRCPV}"

EXTRA_OECMAKE += " \
    -DBUILD_SSE=OFF \
"

FILES_${PN} += " \
    ${libdir}/lv2 \
"
