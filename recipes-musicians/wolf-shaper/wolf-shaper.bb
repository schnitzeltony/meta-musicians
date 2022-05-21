SUMMARY = "Wolf Shaper is a waveshaper plugin with a graph editor"
HOMEPAGE = "https://pdesaulniers.github.io/wolf-shaper/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"

DEPENDS = " \
    jack \
    dssi \
    lv2 \
"

inherit pkgconfig lv2-turtle-helper pack_audio_plugins

SRC_URI = "gitsm://github.com/pdesaulniers/wolf-shaper.git;branch=master;protocol=https"
SRCREV = "73f7f2caa0ac9552cc5ec652e610b3fdd7529b93"
S = "${WORKDIR}/git"
PV = "0.1.8"

EXTRA_OEMAKE += " \
    PREFIX=${prefix} \
    NOOPT=true \
    SKIP_STRIPPING=true \
    BUILD_VST2=true \
    BUILD_LV2=true \
    BUILD_DSSI=true \
    BUILD_JACK=true \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} install
}
