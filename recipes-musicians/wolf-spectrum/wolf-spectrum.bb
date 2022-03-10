SUMMARY = "Wolf Spectrum is a free spectrogram plugin"
HOMEPAGE = "https://github.com/pdesaulniers/wolf-spectrum"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"

DEPENDS = " \
    jack \
    lv2 \
"

inherit pkgconfig lv2-turtle-helper pack_audio_plugins

SRC_URI = "gitsm://github.com/pdesaulniers/wolf-spectrum.git;branch=master;protocol=https"
SRCREV = "87d7aca59e295141a1e8019788267d3ef6d6cae7"
S = "${WORKDIR}/git"
PV = "1.0.0"

EXTRA_OEMAKE += " \
    PREFIX=${prefix} \
    NOOPT=true \
    SKIP_STRIPPING=true \
    BUILD_VST2=true \
    BUILD_LV2=true \
    BUILD_JACK=true \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} install
}
